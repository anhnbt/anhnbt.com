function toPerfectName(elm) {
  elm.innerHTML = "Đang đổi tên...";
  const resultDOM = document.getElementById("result"),
    msg = document.getElementById("aMessage"),
    myName = document.getElementById("myName");
  const xhttp = new XMLHttpRequest();
  if (myName.value === "") {
    elm.innerHTML = 'Tạo tên kí tự đặc biệt';
    myName.focus();
    myName.classList.add("is-danger");
    msg.innerHTML = `<div class="message is-danger" role="alert"><p class="message-body">Ô nhập tên không được bỏ trống!</p></div>`;
    return;
  }
  try {
    const req = {
      "myName": myName.value.trim(),
      "symbolLeft": document.getElementById("symbolLeft").value,
      "symbolRight": document.getElementById("symbolRight").value,
      "symbolCenter": document.getElementById("symbolCenter").value
  };
    elm.classList.add("is-loading");
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        myName.classList.remove("is-danger");
        const resp = JSON.parse(this.responseText);
        let html = '';
        if (resp.recommendChars) {
          for (let i = 0; i < resp.recommendChars.length; i++) {
            html += `<div class="field has-addons">
                <div class="control is-expanded">
                    <input type="text" class="input" value="${resp.recommendChars[i]}" onfocus="this.select();" onmouseup="return false;">
                </div>
                <div class="control">
                    <a class="button is-info" onclick="copyToClipboardInput(this);">
                    Sao chép
                    </a>
                </div>
            </div>`;
          }
        }
        if (resp.chars) {
          for (let i = 0; i < resp.chars.length; i++) {
            html += `<div class="field has-addons">
                <div class="control is-expanded">
                    <input type="text" class="input" value="${resp.chars[i]}" onfocus="this.select();" onmouseup="return false;">
                </div>
                <div class="control">
                    <a class="button is-info" onclick="copyToClipboardInput(this);">
                    Sao chép
                    </a>
                </div>
            </div>`;
          }
        }
        resultDOM.innerHTML = html;
        setTimeout(function () {
          msg.innerHTML = '<p class="has-text-centered has-text-success">↓↓ Thành công! Kéo xuống dưới nhé ↓↓<p>';
          elm.classList.remove("is-loading");
          elm.innerHTML = "Tạo lại tên";
        }, 2000);
      }
    };
    xhttp.open("POST", "https://api.anhnbt.com", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(req));
  } catch (e) {
    msg.innerHTML = "Đã xảy ra lỗi ngoại lệ: " + e.description;
  }
}

function loadMoreNickName(btn, nextPage, recordsPerPage) {
  const nickNameList = document.getElementById("nickNameList");
  nickNameList.innerHTML = `<img class="d-block mx-auto" src="${baseURL}/images/spinner.gif" alt="loading"><p class="text-center">Đang tải dữ liệu ...</p>`;

  const http = new XMLHttpRequest();
  http.open("POST", baseURL + "/ajax/loadMoreNickName.php", true);
  http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  http.onreadystatechange = function () {
    if (http.readyState == 4 && http.status == 200) {
      setTimeout(() => {
        btn.remove();
        nickNameList.innerHTML = http.responseText;
      }, 200);
    }
  };
  http.send("nextPage=" + nextPage + "&recordsPerPage=" + recordsPerPage);
  gtag("event", "pagination", {
    event_category: "button",
    event_label: "load_page_" + nextPage,
  });
}

function copyToClipboardInput(elm) {
  copyToClipboard(elm.parentElement.parentElement.children[0].children[0]);
  elm.classList.remove("is-info");
  elm.classList.add("is-success");
  elm.innerHTML = "Đã chép";
  setTimeout(function () {
    elm.classList.remove("is-success");
    elm.classList.add("is-info");
    elm.innerHTML = "Sao chép";
  }, 1000);
}

function copyToClipboard(t) {
  t.select();
  t.setSelectionRange(0, 99999); /*For mobile devices*/
  document.execCommand("copy");
}

document.addEventListener("DOMContentLoaded", () => {
  const btnClose = document.getElementById("btn-close");
  if (btnClose) {
    btnClose.addEventListener("click", function () {
      console.log("close");
      document.getElementById("copyModal").classList.toggle("is-active");
    });
  }
  const $navbarBurgers = Array.prototype.slice.call(
    document.querySelectorAll(".navbar-burger"),
    0
  );

  if ($navbarBurgers.length > 0) {
    $navbarBurgers.forEach((el) => {
      el.addEventListener("click", () => {
        const target = el.dataset.target;
        const $target = document.getElementById(target);
        el.classList.toggle("is-active");
        $target.classList.toggle("is-active");
      });
    });
  }
});
const tags = document.querySelectorAll(".tag");
for (let i = 0; i < tags.length; i++) {
  const s = tags[i].getAttribute("data-clipboard-text");
  if (s) {
    tags[i].addEventListener("click", function () {
      document.getElementById("copyModal").classList.toggle("is-active");
      document.getElementById("txtSymbol").value = s;
    });
  }
}
