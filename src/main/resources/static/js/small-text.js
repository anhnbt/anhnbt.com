const letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz",
  letterNumber = "0123456789";
const symbols = {
  "small-caps": {
    before: function (e) {
      return e.toLowerCase();
    },
    searches: "abcdđefghijklmnoprtuvwyzqæƀðʒǝɠɨłꟽɯœɔȣꝵʉγλπρψ".split(""),
    replaces: "ᴀʙᴄᴅᴆᴇғɢʜɪᴊᴋʟᴍɴᴏᴘʀᴛᴜᴠᴡʏᴢǫᴁᴃᴆᴣⱻʛᵻᴌꟺꟺɶᴐᴕꝶᵾᴦᴧᴨᴩᴪ".split(""),
    after: function (e) {
      return e;
    },
  },
  subscript: {
    searches: (letter + letterNumber).split(""),
    replaces:
      "ₐ ᵦ ꜀ d ₑ f ₉ ₕ ᵢ ⱼ ₖ ₗ ₘ ₙ ₒ ₚ q ᵣ ₛ ₜ ᵤ ᵥ w ₓ ᵧ ₂ ₐ ᵦ ꜀ d ₑ f ₉ ₕ ᵢ ⱼ ₖ ₗ ₘ ₙ ₒ ₚ q ᵣ ₛ ₜ ᵤ ᵥ w ₓ ᵧ ₂ ₀ ₁ ₂ ₃ ₄ ₅ ₆ ₇ ₈ ₉".split(
        " "
      ),
  },
  superscript: {
    searches: (letter + letterNumber).split(""),
    replaces:
      "ᴬ ᴮ ᑦ ᴰ ᴱ ⸁ ᴳ ᴴ ᴵ ᴶ ᴷ ᴸ ᴹ ᴺ ᴼ ᴾ ۹ ᴿ ᔆ ᵀ ᵁ ⱽ ᵂ ᕽ ʸ ᙆ ᵃ ᵇ ᶜ ᵈ ᵉ ᶠ ᵍ ʰ ⁱ ʲ ᵏ ˡ ᵐ ⁿ ᵒ ᵖ ۹ ʳ ˢ ᵗ ᵘ ᵛ ʷ ˣ ʸ ᶻ ⁰ ¹ ² ³ ⁴ ⁵ ⁶ ⁷ ⁸ ⁹".split(
        " "
      ),
  },
};

function convertText(text, type = "small-caps") {
  const textSearches = symbols[type].searches;
  const textReplaces = symbols[type].replaces;
  for (const i in (void 0 !== symbols[type].before &&
    (text = symbols[type].before(text)),
  textSearches)) {
    if (type === "small-caps") {
      text = text
        .normalize("NFD")
        .replace(new RegExp(textSearches[i], "g"), textReplaces[i]);
    } else {
      text = text
        .normalize("NFD")
        .replace(new RegExp(textSearches[i], "g"), textReplaces[i]);
    }
  }
  return (
    void 0 !== symbols[type].after && (text = symbols[type].after(text)), text
  );
}

function onConvertTextToFancy() {
  let text = document.getElementById("input").value;
  for (let type in symbols) {
    document.getElementById(type).value = convertText(text, type);
  }
}

function copyToClipboardInput(elm) {
  copyToClipboard(elm.parentElement.parentElement.children[0].children[0]),
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
