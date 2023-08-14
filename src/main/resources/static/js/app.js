function toPerfectName(elm) {
    elm.innerHTML = "Đang đổi tên...";
    const resultDOM = document.getElementById("result"), msg = document.getElementById("txtMessage"),
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
            if (this.readyState === 4 && this.status === 200) {
                myName.classList.remove("is-danger");
                const resp = JSON.parse(this.responseText);
                let html = '<div class="tabs mb-1"><ul class="m-0"><li id="tabRecommendChars" class="is-active" onclick="openTab(event,\'recommendChars\')"><a>Gợi ý</a></li>' +
                    '<li id="tabAll" onclick="openTab(event,\'all\')"><a>Tất cả</a></li>';
                html += '</ul></div>';
                if (resp.recommendChars) {
                    html += '<div id="recommendChars" class="content-tab" style="overflow-y:scroll; height:150px;">';
                    for (let i = 0; i < resp.recommendChars.length; i++) {
                        html += `<div class="field has-addons">
                <div class="control is-expanded">
                    <input type="text" class="input" value="${resp.recommendChars[i]}" onfocus="this.select();" onmouseup="return false;">
                </div>
                <div class="control">
                    <button type="button" class="button is-primary" onclick="copyToClipboardInput(this);">
                    Sao chép
                    </button>
                </div>
            </div>`;
                    }
                    html += '</div>';
                }
                if (resp.chars) {
                    html += '<div id="all" class="content-tab" style="overflow-y:scroll; height:150px; display:none">';
                    for (let i = 0; i < resp.chars.length; i++) {
                        html += `<div class="field has-addons">
                <div class="control is-expanded">
                    <input type="text" class="input" value="${resp.chars[i]}" onfocus="this.select();" onmouseup="return false;">
                </div>
                <div class="control">
                    <button type="button" class="button is-primary" onclick="copyToClipboardInput(this);">
                    Sao chép
                    </button>
                </div>
            </div>`;
                    }
                    html += '</div>';
                }
                resultDOM.innerHTML = html;
                setTimeout(function () {
                    msg.innerHTML = '<p class="has-text-centered has-text-success">↓↓ Thành công! Kéo xuống dưới nhé ↓↓<p>';
                    elm.classList.remove("is-loading");
                    elm.innerHTML = "Tạo lại tên";
                }, 2000);
            }
        };
        xhttp.open("POST", "https://anhnbt.kitudacbiet.com", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.send(JSON.stringify(req));
    } catch (e) {
        msg.innerHTML = "Đã xảy ra lỗi ngoại lệ: " + e.description;
    }
}

function loadMoreNickName(btn, nextPage, recordsPerPage) {
    const nickNameList = document.getElementById("nickNameList");
    nickNameList.innerHTML = `<img class="d-block mx-auto" src="${contextPath}images/spinner.gif" alt="loading"><p class="text-center">Đang tải dữ liệu ...</p>`;

    const http = new XMLHttpRequest();
    http.open("GET", contextPath + "nicknames?page=" + nextPage + "&size=" + recordsPerPage, true);
    http.setRequestHeader("Content-type", "application/json");
    http.onreadystatechange = function () {
        if (http.readyState === 4 && http.status === 200) {
            if (http.responseText) {
                const resp = JSON.parse(http.responseText);
                btn.remove();
                let html = '<div class="box tags">';
                for (let i = 0; i < resp.content.length; i++) {
                    html += '<span class="tag" data-clipboard-text="' + resp.content[i].nickname + '">' + resp.content[i].nickname + '</span>&nbsp;';
                }
                html += `</div><div class="has-text-centered mb-1">
                    <button onclick="loadMoreNickName(this, ${nextPage}+1, ${recordsPerPage})" class="button is-primary is-small">Xem tiếp »</button>
                   </div>`;
                nickNameList.innerHTML = html;
            } else {
                nickNameList.innerHTML = '<div class="has-background-danger p-2 mb-2">Lỗi không nhận được dữ liệu từ máy chủ</div>';
            }
        } else if (http.status === 204) {
            nickNameList.innerHTML = `<div class="has-background-warning p-2 mb-2">Đã tải hết dữ liệu.</div><div class="has-text-centered mb-1">
                    <button onclick="loadMoreNickName(this, 1, ${recordsPerPage})" class="button is-primary is-small">Tải lại</button>
                   </div>`;
        } else {
            nickNameList.innerHTML = '<div class="has-background-danger p-2 mb-2">Lỗi không xác định.</div>';
        }
    };
    http.send();
    // gtag("event", "pagination", {
    //     event_category: "button",
    //     event_label: "load_page_" + nextPage,
    // });
}

function copyToClipboardInputFrmModal(elm) {
    copyToClipboard(elm.parentElement.parentElement.children[0].children[1]);
    elm.classList.remove("is-primary");
    elm.classList.add("is-success");
    elm.innerHTML = "Đã chép";
    setTimeout(function () {
        elm.classList.remove("is-success");
        elm.classList.add("is-primary");
        elm.innerHTML = "Sao chép";
    }, 1000);
}

function copyToClipboardInput(elm) {
    copyToClipboard(elm.parentElement.parentElement.children[0].children[0]);
    elm.classList.remove("is-primary");
    elm.classList.add("is-success");
    elm.innerHTML = "Đã chép";
    setTimeout(function () {
        elm.classList.remove("is-success");
        elm.classList.add("is-primary");
        elm.innerHTML = "Sao chép";
    }, 1000);
}

function copyToClipboardInputWithLabel(elm) {
    copyToClipboard(elm.parentElement.parentElement.children[0].children[0]);
    elm.classList.remove("is-primary");
    elm.classList.add("is-success");
    elm.innerHTML = "Đã chép";
    setTimeout(function () {
        elm.classList.remove("is-success");
        elm.classList.add("is-primary");
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
            document.getElementById("copyModal").classList.toggle("is-active");
        });
    }
    const $navbarBurgers = Array.prototype.slice.call(document.querySelectorAll(".navbar-burger"), 0);

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
function openTab(evt, tabName) {
    var i, x, tabAll, tabRecommendChars;
    x = document.getElementsByClassName("content-tab");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    tabAll = document.getElementById("tabAll");
    tabAll.classList.remove("is-active");
    tabRecommendChars = document.getElementById("tabRecommendChars");
    tabRecommendChars.classList.remove("is-active");
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.classList.toggle("is-active");
}
