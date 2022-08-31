function getKiTuTangHinh(elm) {
  elm.innerHTML = "Chờ chút...";
  const output = document.getElementById("ki-tu-tang-hinh");
  try {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        elm.classList.remove("btn-primary");
        elm.innerHTML = "Thành công";
        elm.classList.add("btn-success");
        output.value = JSON.parse(this.responseText);
        setTimeout(function () {
          elm.classList.remove("btn-success");
          elm.innerHTML = "Thử tên khác";
          elm.classList.add("btn-primary");
        }, 500);
      } else {
        output.value = "Máy chủ không phản hồi. Vui lòng thử lại sau!";
      }
    };
    xhttp.open("GET", baseURL + "/ajax/ki-tu-tang-hinh.php", true);
    xhttp.send();
  } catch (e) {
    output.value = "Đã xảy ra lỗi ngoại lệ: " + e.description;
  }
}

function copyToClipboardInput(elm) {
  copyToClipboard(
    elm.parentElement.parentElement.children[0].children[1].children[0]
  ),
    elm.classList.add("is-success"),
    (elm.innerHTML = "Đã chép");
  setTimeout(function () {
    elm.classList.remove("is-success");
    elm.innerHTML = "Sao chép";
  }, 1000);
}

function copyToClipboard(t) {
  /* Select the text field */
  t.select();
  t.setSelectionRange(0, 99999); /*For mobile devices*/

  /* Copy the text inside the text field */
  document.execCommand("copy");
}
