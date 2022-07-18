const letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz",
  letterNumber = "012345678910";
const symbols = {
  "anhnbt-code-001": {
    searches: (letter + letterNumber).split(""),
    replaces:
      "Ⓐ Ⓑ Ⓒ Ⓓ Ⓔ Ⓕ Ⓖ Ⓗ Ⓘ Ⓙ Ⓚ Ⓛ Ⓜ Ⓝ Ⓞ Ⓟ Ⓠ Ⓡ Ⓢ Ⓣ Ⓤ Ⓥ Ⓦ Ⓧ Ⓨ Ⓩ ⓐ ⓑ © ⓓ ⓔ Ⓕ ⓖ ⓗ ⓘ ⓙ ⓚ ⓛ ⓜ ⓝ ⓞ ⓟ ⓠ ⓡ ⓢ ⓣ ⓤ ⓥ ⓦ ⓧ ⓨ ⓩ ⓪ ① ② ③ ④ ⑤ ⑥ ⑦ ⑧ ⑨ ⑩".split(
        " "
      ),
  },
  "anhnbt-code-002": {
    searches: (letter + letterNumber).split(""),
    replaces:
      "🅐 🅑 🅒 🅓 🅔 🅕 🅖 🅗 🅘 🅙 🅚 🅛 🅜 🅝 🅞 🅟 🅠 🅡 🅢 🅣 🅤 🅥 🅦 🅧 🅨 🅩 🅐 🅑 🅒 🅓 🅔 🅕 🅖 🅗 🅘 🅙 🅚 🅛 🅜 🅝 🅞 🅟 🅠 🅡 🅢 🅣 🅤 🅥 🅦 🅧 🅨 🅩 ⓪ ❶ ❷ ❸ ❹ ❺ ❻ ❼ ❽ ❾ ❿".split(
        " "
      ),
  },
  "anhnbt-code-003": {
    searches: (letter + letterNumber).split(""),
    replaces:
      "𝙰 𝙱 𝙲 𝙳 𝙴 𝙵 𝙶 𝙷 𝙸 𝙹 𝙺 𝙻 𝙼 𝙽 𝙾 𝙿 𝚀 𝚁 𝚂 𝚃 𝚄 𝚅 𝚆 𝚇 𝚈 𝚉 𝚊 𝚋 𝚌 𝚍 𝚎 𝚏 𝚐 𝚑 𝚒 𝚓 𝚔 𝚕 𝚖 𝚗 𝚘 𝚙 𝚚 𝚛 𝚜 𝚝 𝚞 𝚟 𝚠 𝚡 𝚢 𝚣 𝟎 𝟷 𝟸 𝟹 𝟺 𝟻 𝟼 𝟽 𝟾 𝟿 1𝟎".split(
        " "
      ),
  },
  "anhnbt-code-004": {
    searches: letter.split(""),
    replaces:
      "Ａ Ｂ Ｃ Ｄ Ｅ Ｆ Ｇ Ｈ Ｉ Ｊ Ｋ Ｌ Ｍ Ｎ Ｏ Ｐ Ｑ Ｒ Ｓ Ｔ Ｕ Ｖ Ｗ Ｘ Ｙ Ｚ ａ ｂ ｃ ｄ ｅ ｆ ｇ ｈ ｉ ｊ ｋ ｌ ｍ ｎ ｏ ｐ ｑ ｒ ｓ ｔ ｕ ｖ ｗ ｘ ｙ ｚ ａ ｂ ｃ ｄ ｅ ｆ ｇ ｈ ｉ ｊ ｋ ｌ ｍ ｎ ｏ ｐ ｑ ｒ ｓ ｔ ｕ ｖ ｗ ｘ ｙ ｚ".split(
        " "
      ),
  },
  "anhnbt-code-005": {
    searches: letter.split(""),
    replaces:
      "ɐ b ɔ d ǝ ɟ ɓ ɥ ı ɾ ʞ l ɯ n o d b ɹ s ʇ n ʌ ʍ x ʎ z ɐ b ɔ d ǝ ɟ ɓ ɥ ı ɾ ʞ l ɯ n o d b ɹ s ʇ n ʌ ʍ x ʎ z".split(
        " "
      ),
  },
  "anhnbt-code-006": {
    searches: letter.split(""),
    replaces:
      "🄰 🄱 🄲 🄳 🄴 🄵 🄶 🄷 🄸 🄹 🄺 🄻 🄼 🄽 🄾 🄿 🅀 🅁 🅂 🅃 🅄 🅅 🅆 🅇 🅈 🅉 🄰 🄱 🄲 🄳 🄴 🄵 🄶 🄷 🄸 🄹 🄺 🄻 🄼 🄽 🄾 🄿 🅀 🅁 🅂 🅃 🅄 🅅 🅆 🅇 🅈 🅉".split(
        " "
      ),
  },
  "anhnbt-code-007": {
    searches: letter.split(""),
    replaces:
      "🅰 🅱 🅲 🅳 🅴 🅵 🅶 🅷 🅸 🅹 🅺 🅻 🅼 🅽 🅾 🅿 🆀 🆁 🆂 🆃 🆄 🆅 🆆 🆇 🆈 🆉 🅰 🅱 🅲 🅳 🅴 🅵 🅶 🅷 🅸 🅹 🅺 🅻 🅼 🅽 🅾 🅿 🆀 🆁 🆂 🆃 🆄 🆅 🆆 🆇 🆈 🆉".split(
        " "
      ),
  },
  "anhnbt-code-008": {
    searches: (letter + letterNumber).split(""),
    replaces:
      "𝔸 𝔹 ℂ 𝔻 𝔼 𝔽 𝔾 ℍ 𝕀 𝕁 𝕂 𝕃 𝕄 ℕ 𝕆 ℙ ℚ ℝ 𝕊 𝕋 𝕌 𝕍 𝕎 𝕏 𝕐 ℤ 𝕒 𝕓 𝕔 𝕕 𝕖 𝕗 𝕘 𝕙 𝕚 𝕛 𝕜 𝕝 𝕞 𝕟 𝕠 𝕡 𝕢 𝕣 𝕤 𝕥 𝕦 𝕧 𝕨 𝕩 𝕪 𝕫 𝟘 𝟙 𝟚 𝟛 𝟜 𝟝 𝟞 𝟟𝟠 𝟡 𝟙𝟘".split(
        " "
      ),
  },
  "anhnbt-code-009": {
    searches: letter.split(""),
    replaces:
      "A⃣ B⃣ C⃣ D⃣ E⃣ F⃣ G⃣ H⃣ I⃣ J⃣ K⃣ L⃣ M⃣ N⃣ O⃣ P⃣ Q⃣ R⃣ S⃣ T⃣ U⃣ V⃣ W⃣ X⃣ Y⃣ Z⃣ a⃣ b⃣ c⃣ d⃣ e⃣ f⃣ g⃣ h⃣ i⃣ j⃣ k⃣ l⃣ m⃣ n⃣ o⃣ p⃣ q⃣ r⃣ s⃣ t⃣ u⃣ v⃣ w⃣ x⃣ y⃣ z⃣  ".split(
        " "
      ),
  },
  "anhnbt-code-010": {
    searches: letter.split(""),
    replaces:
      "A⃟ B⃟ C⃟ D⃟ E⃟ F⃟ G⃟ H⃟ I⃟ J⃟ K⃟ L⃟ M⃟ N⃟ O⃟ P⃟ Q⃟ R⃟ S⃟ T⃟ U⃟ V⃟ W⃟ X⃟ Y⃟ Z⃟ a⃟ b⃟ c⃟ d⃟ e⃟ f⃟ g⃟ h⃟ i⃟ j⃟ k⃟ l⃟ m⃟ n⃟ o⃟ p⃟ q⃟ r⃟ s⃟ t⃟ u⃟ v⃟ w⃟ x⃟ y⃟ z⃟".split(
        " "
      ),
  },
  "anhnbt-code-011": {
    searches: letter.split(""),
    replaces:
      "A҈ B҈ C҈ D҈ E҈ F҈ G҈ H҈ I҈ J҈ K҈ L҈ M҈ N҈ O҈ P҈ Q҈ R҈ S҈ T҈ U҈ V҈ W҈ X҈ Y҈ Z҈ a҉ b҉ c҉ d҉ e҉ f҉ g҉ h҉ i҉ j҉ k҉ l҉ m҉ n҉ o҉ p҉ q҉ r҉ s҉ t҉ u҉ v҉ w҉ x҉ y҉ z҉".split(
        " "
      ),
  },
  "anhnbt-code-012": {
    searches: letter.split(""),
    replaces:
      "A҉҉ B҉҉ C҉҉ D҉҉ E҉҉ F҉҉ G҉҉ H҉҉ I҉҉ J҉҉ K҉҉ L҉҉ M҉҉ N҉҉ O҉҉ P҉҉ Q҉҉ R҉҉ S҉҉ T҉҉ U҉҉ V҉҉ W҉҉ X҉҉ Y҉҉ Z҉҉ a҉҉ b҉҉ c҉҉ d҉҉ e҉҉ f҉҉ g҉҉ h҉҉ i҉҉ j҉҉ k҉҉ l҉҉ m҉҉ n҉҉ o҉҉ p҉҉ q҉҉ r҉҉ s҉҉ t҉҉ u҉҉ v҉҉ w҉҉ x҉҉ y҉҉ z҉҉".split(
        " "
      ),
  },
  "anhnbt-code-013": {
    searches: letter.split(""),
    replaces:
      "A̸ B̸ C̸ D̸ E̸ F̸ G̸ H̸ I̸ J̸ K̸ L̸ M̸ N̸ O̸ P̸ Q̸ R̸ S̸ T̸ U̸ V̸ W̸ X̸ Y̸ Z̸ a̸ b̸ c̸ d̸ e̸ f̸ g̸ h̸ i̸ j̸ k̸ l̸ m̸ n̸ o̸ p̸ q̸ r̸ s̸ t̸ u̸ v̸ w̸ x̸ y̸ z̸ ".split(
        " "
      ),
  },
  "anhnbt-code-014": {
    searches: letter.split(""),
    replaces:
      "A̷ B̷ C̷ D̷ E̷ F̷ G̷ H̷ I̷ J̷ K̷ L̷ M̷ N̷ O̷ P̷ Q̷ R̷ S̷ T̷ U̷ V̷ W̷ X̷ Y̷ Z̷ a̷ b̷ c̷ d̷ e̷ f̷ g̷ h̷ i̷ j̷ k̷ l̷ m̷ n̷ o̷ p̷ q̷ r̷ s̷ t̷ u̷ v̷ w̷ x̷ y̷ z̷ ".split(
        " "
      ),
  },
  "anhnbt-code-015": {
    searches: letter.split(""),
    replaces:
      "A͟ B͟ C͟ D͟ E͟ F͟ G͟ H͟ I͟ J͟ K͟ L͟ M͟ N͟ O͟ P͟ Q͟ R͟ S͟ T͟ U͟ V͟ W͟ X͟ Y͟ Z͟ a͟ b͟ c͟ d͟ e͟ f͟ g͟ h͟ i͟ j͟ k͟ l͟ m͟ n͟ o͟ p͟ q͟ r͟ s͟ t͟ u͟ v͟ w͟ x͟ y͟ z͟".split(
        " "
      ),
  },
  "anhnbt-code-016": {
    searches: letter.split(""),
    replaces:
      "A̵ B̵ C̵ D̵ E̵ F̵ G̵ H̵ I̵ J̵ K̵ L̵ M̵ N̵ O̵ P̵ Q̵ R̵ S̵ T̵ U̵ V̵ W̵ X̵ Y̵ Z̵ a̵ b̵ c̵ d̵ e̵ f̵ g̵ h̵ i̵ j̵ k̵ l̵ m̵ n̵ o̵ p̵ q̵ r̵ s̵ t̵ u̵ v̵ w̵ x̵ y̵ z̵ ".split(
        " "
      ),
  },
  "anhnbt-code-017": {
    searches: letter.split(""),
    replaces:
      "A̲ B̲ C̲ D̲ E̲ F̲ G̲ H̲ I̲ J̲ K ̲L ̲M ̲N ̲O ̲P ̲Q ̲R ̲S ̲T U̲ V̲ W̲ X̲ Y̲ Z̲ a̲ b̲ c̲ d̲ e̲ f̲ g̲ h̲ i̲ j̲ k̲ l̲ m̲ n̲ o̲ p̲ q̲ r̲ s̲ t̲ u̲ v̲ w̲ x̲ y̲ z̲".split(
        " "
      ),
  },
  "anhnbt-code-018": {
    searches: letter.split(""),
    replaces:
      "⒜ ⒝ ⒞ ⒟ ⒠ ⒡ ⒢ ⒣ ⒤ ⒥ ⒦ ⒧ ⒨ ⒩ ⒪ ⒫ ⒬ ⒭ ⒮ ⒯ ⒰ ⒱ ⒲ ⒳ ⒴ ⒵ ⒜ ⒝ ⒞ ⒟ ⒠ ⒡ ⒢ ⒣ ⒤ ⒥ ⒦ ⒧ ⒨ ⒩ ⒪ ⒫ ⒬ ⒭ ⒮ ⒯ ⒰ ⒱ ⒲ ⒳ ⒴ ⒵".split(
        " "
      ),
  },
  "anhnbt-code-019": {
    searches: letter.split(""),
    replaces:
      "a̫ b̫ c̫ d̫ e̫ f̫ g̫ h̫ i̫ j̫ k̫ l̫ m̫ n̫ o̫ p̫ q̫ r̫ s̫ t̫ u̫ v̫ w̫ x̫ y̫ z̫ a̫ b̫ c̫ d̫ e̫ f̫ g̫ h̫ i̫ j̫ k̫ l̫ m̫ n̫ o̫ p̫ q̫ r̫ s̫ t̫ u̫ v̫ w̫ x̫ y̫ z̫".split(
        " "
      ),
  },
  "anhnbt-code-020": {
    searches: letter.split(""),
    replaces:
      "A͜͡ B͜͡ C͜͡ D͜͡ E͜͡ F͜͡ G͜͡ H͜͡ I͜͡ J͜͡ K͜͡ L͜͡ M͜͡ N͜͡ O͜͡ P͜͡ Q͜͡ R͜͡ S͜͡ T͜͡ U͜͡ V͜͡ W͜͡ X͜͡ Y͜͡ Z͜͡ A͜͡ B͜͡ C͜͡ D͜͡ E͜͡ F͜͡ G͜͡ H͜͡ I͜͡ J͜͡ K͜͡ L͜͡ M͜͡ N͜͡ O͜͡ P͜͡ Q͜͡ R͜͡ S͜͡ T͜͡ U͜͡ V͜͡ W͜͡ X͜͡ Y͜͡ Z͜͡".split(
        " "
      ),
  },
  "anhnbt-code-021": {
    searches: letter.split(""),
    replaces:
      "A̺͆ B̺͆ C̺͆ D̺͆ E̺͆ F̺͆ G̺͆ H̺͆ I̺͆ J̺͆ K̺͆ L̺͆ M̺͆ N̺͆ O̺͆ P̺͆ Q̺͆ R̺͆ S̺͆ T̺͆ U̺͆ V̺͆ W̺͆ X̺͆ Y̺͆ Z̺͆ A̺͆ B̺͆ C̺͆ D̺͆ E̺͆ F̺͆ G̺͆ H̺͆ I̺͆ J̺͆ K̺͆ L̺͆ M̺͆ N̺͆ O̺͆ P̺͆ Q̺͆ R̺͆ S̺͆ T̺͆ U̺͆ V̺͆ W̺͆ X̺͆ Y̺͆ Z̺͆".split(
        " "
      ),
  },
  "anhnbt-code-022": {
    searches: letter.split(""),
    replaces:
      "a̾ b̾ c̾ d̾ e̾ f̾ g̾ h̾ i̾ j̾ k̾ l̾ m̾ n̾ o̾ p̾ q̾ r̾ s̾ t̾ u̾ v̾ w̾ x̾ y̾ z̾ a̾ b̾ c̾ d̾ e̾ f̾ g̾ h̾ i̾ j̾ k̾ l̾ m̾ n̾ o̾ p̾ q̾ r̾ s̾ t̾ u̾ v̾ w̾ x̾ y̾ z̾".split(
        " "
      ),
  },
  "anhnbt-code-023": {
    searches: letter.split(""),
    replaces:
      "[̲̅a̲̅] [̲̅b̲̅] [̲̅c̲̅] [̲̅d̲̅] [̲̅e̲̅] [̲̅f̲̅] [̲̅g̲̅] [̲̅h̲̅] [̲̅i̲̅] [̲̅j̲̅] [̲̅k̲̅] [̲̅l̲̅] [̲̅m̲̅] [̲̅n̲̅] [̲̅o̲̅] [̲̅p̲̅] [̲̅q̲̅] [̲̅r̲̅] [̲̅s̲̅] [̲̅t̲̅] [̲̅u̲̅] [̲̅v̲̅] [̲̅w̲̅] [̲̅x̲̅] [̲̅y̲̅] [̲̅z̲̅] [̲̅a̲̅] [̲̅b̲̅] [̲̅c̲̅] [̲̅d̲̅] [̲̅e̲̅] [̲̅f̲̅] [̲̅g̲̅] [̲̅h̲̅] [̲̅i̲̅] [̲̅j̲̅] [̲̅k̲̅] [̲̅l̲̅] [̲̅m̲̅] [̲̅n̲̅] [̲̅o̲̅] [̲̅p̲̅] [̲̅q̲̅] [̲̅r̲̅] [̲̅s̲̅] [̲̅t̲̅] [̲̅u̲̅] [̲̅v̲̅] [̲̅w̲̅] [̲̅x̲̅] [̲̅y̲̅] [̲̅z̲̅]".split(
        " "
      ),
  },
  "anhnbt-code-024": {
    searches: letter.split(""),
    replaces:
      "ä̤ b̤̈ c̤̈ d̤̈ ë̤ f̤̈ g̤̈ ḧ̤ ï̤ j̤̈ k̤̈ l̤̈ m̤̈ n̤̈ ö̤ p̤̈ q̤̈ r̤̈ s̤̈ ẗ̤ ṳ̈ v̤̈ ẅ̤ ẍ̤ ÿ̤ z̤̈ ä̤ b̤̈ c̤̈ d̤̈ ë̤ f̤̈ g̤̈ ḧ̤ ï̤ j̤̈ k̤̈ l̤̈ m̤̈ n̤̈ ö̤ p̤̈ q̤̈ r̤̈ s̤̈ ẗ̤ ṳ̈ v̤̈ ẅ̤ ẍ̤ ÿ̤ z̤̈".split(
        " "
      ),
  },
  "anhnbt-code-025": {
    searches: letter.split(""),
    replaces:
      "Aཽ Bཽ Cཽ Dཽ Eཽ Fཽ Gཽ Hཽ Iཽ Jཽ Kཽ Lཽ Mཽ Nཽ Oཽ Pཽ Qཽ Rཽ Sཽ Tཽ Uཽ Vཽ Wཽ Xཽ Yཽ Zཽ Aཽ Bཽ Cཽ Dཽ Eཽ Fཽ Gཽ Hཽ Iཽ Jཽ Kཽ Lཽ Mཽ Nཽ Oཽ Pཽ Qཽ Rཽ Sཽ Tཽ Uཽ Vཽ Wཽ Xཽ Yཽ Zཽ".split(
        " "
      ),
  },
  "anhnbt-code-026": {
    searches: letter.split(""),
    replaces:
      "A͒ B͒ C͒ D͒ E͒ F͒ G͒ H͒ I͒ J͒ K͒ L͒ M͒ N͒ O͒ P͒ Q͒ R͒ S͒ T͒ U͒ V͒ W͒ X͒ Y͒ Z͒ A͒ B͒ C͒ D͒ E͒ F͒ G͒ H͒ I͒ J͒ K͒ L͒ M͒ N͒ O͒ P͒ Q͒ R͒ S͒ T͒ U͒ V͒ W͒ X͒ Y͒ Z͒".split(
        " "
      ),
  },
  "anhnbt-code-027": {
    searches: letter.split(""),
    replaces:
      "A̬̤̯ B̬̤̯ C̬̤̯ D̬̤̯ E̬̤̯ F̬̤̯ G̬̤̯ H̬̤̯ I̬̤̯ J̬̤̯ K̬̤̯ L̬̤̯ M̬̤̯ N̬̤̯ O̬̤̯ P̬̤̯ Q̬̤̯ R̬̤̯ S̬̤̯ T̬̤̯ U̬̤̯ V̬̤̯ W̬̤̯ X̬̤̯ Y̬̤̯ Z̬̤̯ A̬̤̯ B̬̤̯ C̬̤̯ D̬̤̯ E̬̤̯ F̬̤̯ G̬̤̯ H̬̤̯ I̬̤̯ J̬̤̯ K̬̤̯ L̬̤̯ M̬̤̯ N̬̤̯ O̬̤̯ P̬̤̯ Q̬̤̯ R̬̤̯ S̬̤̯ T̬̤̯ U̬̤̯ V̬̤̯ W̬̤̯ X̬̤̯ Y̬̤̯ Z̬̤̯".split(
        " "
      ),
  },
  "anhnbt-code-028": {
    searches: letter.split(""),
    replaces:
      "a̘̫͈̭͌͛͌̇̇̍ b͎̣̫͈̥̗͒͌̃͑̔̾ͅ c͔ͣͦ́́͂ͅ d̥̝̮͙͈͂̐̇ͮ̏̔̀̚ͅ e̮̟͈̣̖̰̩̹͈̾ͨ̑͑ f̳͉̼͉̙͔͈̂̉ g͎͚̥͎͔͕ͥ̿ h͚̖̜̍̃͐ i̞̟̫̺ͭ̒ͭͣ j͇̗̲̞̪̹̝̫̞ͬ͐̀ͧ̿ k̲̱̠̞̖ͧ̔͊̇̽̿̑ͯͅ l͕͖͉̭̰ͬ̍ͤ͆̊ͨ m̘͈̺̪͓ͩ͂̾ͪ̀̋ n͉̠̙͉̗̺̋̋̔ͧ̊ o͎̜̓̇ͫ̉͊ͨ͊ p̱̱̬̻̞̩͎̌ͦ̏ q̥̳̭̘̳͔̹̄ͫ̔̌ͭ̿̓ͅ r̼̯̤̈ͭ̃ͨ̆ s̪̭̱̼̼̉̈́ͪ͋̽̚ t̘̟̼̉̈́͐͋͌̊ u̟͎̲͕̼̳͉̲ͮͫͭ̋ͭ͛ͣ̈ v̪̩̜̜̙̜ͨ̽̄ w̠̘̗͖̮̥ͣ̽ͫ͂ x̥͕̮̠̦͉̑̉̄̀̚ y͉̝͖̻̯ͮ̒̂ͮ͋ͫͨ z̼͖̺̠̰͇̙̓͛ͮͩͦ̎ͦ̑ͅ a̘̫͈̭͌͛͌̇̇̍ b͎̣̫͈̥̗͒͌̃͑̔̾ͅ c͔ͣͦ́́͂ͅ d̥̝̮͙͈͂̐̇ͮ̏̔̀̚ͅ e̮̟͈̣̖̰̩̹͈̾ͨ̑͑ f̳͉̼͉̙͔͈̂̉ g͎͚̥͎͔͕ͥ̿ h͚̖̜̍̃͐ i̞̟̫̺ͭ̒ͭͣ j͇̗̲̞̪̹̝̫̞ͬ͐̀ͧ̿ k̲̱̠̞̖ͧ̔͊̇̽̿̑ͯͅ l͕͖͉̭̰ͬ̍ͤ͆̊ͨ m̘͈̺̪͓ͩ͂̾ͪ̀̋ n͉̠̙͉̗̺̋̋̔ͧ̊ o͎̜̓̇ͫ̉͊ͨ͊ p̱̱̬̻̞̩͎̌ͦ̏ q̥̳̭̘̳͔̹̄ͫ̔̌ͭ̿̓ͅ r̼̯̤̈ͭ̃ͨ̆ s̪̭̱̼̼̉̈́ͪ͋̽̚ t̘̟̼̉̈́͐͋͌̊ u̟͎̲͕̼̳͉̲ͮͫͭ̋ͭ͛ͣ̈ v̪̩̜̜̙̜ͨ̽̄ w̠̘̗͖̮̥ͣ̽ͫ͂ x̥͕̮̠̦͉̑̉̄̀̚ y͉̝͖̻̯ͮ̒̂ͮ͋ͫͨ z̼͖̺̠̰͇̙̓͛ͮͩͦ̎ͦ̑ͅ".split(
        " "
      ),
  },
  "anhnbt-code-029": {
    searches: letter.split(""),
    replaces:
      "A̸͟͞ B̸͟͞ C̸͟͞ D̸͟͞ E̸͟͞ F̸͟͞ G̸͟͞ H̸͟͞ I̸͟͞ J̸͟͞ K̸͟͞ L̸͟͞ M̸͟͞ N̸͟͞ O̸͟͞ P̸͟͞ Q̸͟͞ R̸͟͞ S̸͟͞ T̸͟͞ U̸͟͞ V̸͟͞ W̸͟͞ X̸͟͞ Y̸͟͞ Z̸͟͞ A̸͟͞ B̸͟͞ C̸͟͞ D̸͟͞ E̸͟͞ F̸͟͞ G̸͟͞ H̸͟͞ I̸͟͞ J̸͟͞ K̸͟͞ L̸͟͞ M̸͟͞ N̸͟͞ O̸͟͞ P̸͟͞ Q̸͟͞ R̸͟͞ S̸͟͞ T̸͟͞ U̸͟͞ V̸͟͞ W̸͟͞ X̸͟͞ Y̸͟͞ Z̸͟͞".split(
        " "
      ),
  },
  "anhnbt-code-030": {
    searches: letter.split(""),
    replaces:
      "A͚ B͚ C͚ D͚ E͚ F͚ G͚ H͚ I͚ J͚ K͚ L͚ M͚ N͚ O͚ P͚ Q͚ R͚ S͚ T͚ U͚ V͚ W͚ X͚ Y͚ Z͚ A͚ B͚ C͚ D͚ E͚ F͚ G͚ H͚ I͚ J͚ K͚ L͚ M͚ N͚ O͚ P͚ Q͚ R͚ S͚ T͚ U͚ V͚ W͚ X͚ Y͚ Z͚".split(
        " "
      ),
  },
  "anhnbt-code-031": {
    searches: letter.split(""),
    replaces:
      "A͙ B͙ C͙ D͙ E͙ F͙ G͙ H͙ I͙ J͙ K͙ L͙ M͙ N͙ O͙ P͙ Q͙ R͙ S͙ T͙ U͙ V͙ W͙ X͙ Y͙ Z͙ A͙ B͙ C͙ D͙ E͙ F͙ G͙ H͙ I͙ J͙ K͙ L͙ M͙ N͙ O͙ P͙ Q͙ R͙ S͙ T͙ U͙ V͙ W͙ X͙ Y͙ Z͙".split(
        " "
      ),
  },
  "anhnbt-code-032": {
    searches: letter.split(""),
    replaces:
      "A̤̮ B̤̮ C̤̮ D̤̮ E̤̮ F̤̮ G̤̮ H̤̮ I̤̮ J̤̮ K̤̮ L̤̮ M̤̮ N̤̮ O̤̮ P̤̮ Q̤̮ R̤̮ S̤̮ T̤̮ Ṳ̮ V̤̮ W̤̮ X̤̮ Y̤̮ Z̤̮ A̤̮ B̤̮ C̤̮ D̤̮ E̤̮ F̤̮ G̤̮ H̤̮ I̤̮ J̤̮ K̤̮ L̤̮ M̤̮ N̤̮ O̤̮ P̤̮ Q̤̮ R̤̮ S̤̮ T̤̮ Ṳ̮ V̤̮ W̤̮ X̤̮ Y̤̮ Z̤̮".split(
        " "
      ),
  },
  "anhnbt-code-033": {
    searches: letter.split(""),
    replaces:
      "A҈ B҈ C҈ D҈ E҈ F҈ G҈ H҈ I҈ J҈ K҈ L҈ M҈ N҈ O҈ P҈ Q҈ R҈ S҈ T҈ U҈ V҈ W҈ X҈ Y҈ Z҈ A҈ B҈ C҈ D҈ E҈ F҈ G҈ H҈ I҈ J҈ K҈ L҈ M҈ N҈ O҈ P҈ Q҈ R҈ S҈ T҈ U҈ V҈ W҈ X҈ Y҈ Z҈".split(
        " "
      ),
  },
  "anhnbt-code-034": {
    searches: letter.split(""),
    replaces:
      "Ă B̆ C̆ D̆ Ĕ F̆ Ğ H̆ Ĭ J̆ K̆ L̆ M̆ N̆ Ŏ P̆ Q̆ R̆ S̆ T̆ Ŭ V̆ W̆ X̆ Y̆ Z̆ Ă B̆ C̆ D̆ Ĕ F̆ Ğ H̆ Ĭ J̆ K̆ L̆ M̆ N̆ Ŏ P̆ Q̆ R̆ S̆ T̆ Ŭ V̆ W̆ X̆ Y̆ Z̆".split(
        " "
      ),
  },
  "anhnbt-code-035": {
    searches: letter.split(""),
    replaces:
      "Ḁͦ B̥ͦ C̥ͦ D̥ͦ E̥ͦ F̥ͦ G̥ͦ H̥ͦ I̥ͦ J̥ͦ K̥ͦ L̥ͦ M̥ͦ N̥ͦ O̥ͦ P̥ͦ Q̥ͦ R̥ͦ S̥ͦ T̥ͦ U̥ͦ V̥ͦ W̥ͦ X̥ͦ Y̥ͦ Z̥ͦ Ḁͦ B̥ͦ C̥ͦ D̥ͦ E̥ͦ F̥ͦ G̥ͦ H̥ͦ I̥ͦ J̥ͦ K̥ͦ L̥ͦ M̥ͦ N̥ͦ O̥ͦ P̥ͦ Q̥ͦ R̥ͦ S̥ͦ T̥ͦ U̥ͦ V̥ͦ W̥ͦ X̥ͦ Y̥ͦ Z̥ͦ".split(
        " "
      ),
  },
  "anhnbt-code-036": {
    searches: letter.split(""),
    replaces:
      "A༙ B༙ C༙ D༙ E༙ F༙ G༙ H༙ I༙ J༙ K༙ L༙ M༙ N༙ O༙ P༙ Q༙ R༙ S༙ T༙ U༙ V༙ W༙ X༙ Y༙ Z༙ A༙ B༙ C༙ D༙ E༙ F༙ G༙ H༙ I༙ J༙ K༙ L༙ M༙ N༙ O༙ P༙ Q༙ R༙ S༙ T༙ U༙ V༙ W༙ X༙ Y༙ Z༙".split(
        " "
      ),
  },
  "anhnbt-code-037": {
    searches: letter.split(""),
    replaces:
      "A͓̽ B͓̽ C͓̽ D͓̽ E͓̽ F͓̽ G͓̽ H͓̽ I͓̽ J͓̽ K͓̽ L͓̽ M͓̽ N͓̽ O͓̽ P͓̽ Q͓̽ R͓̽ S͓̽ T͓̽ U͓̽ V͓̽ W͓̽ X͓̽ Y͓̽ Z͓̽ A͓̽ B͓̽ C͓̽ D͓̽ E͓̽ F͓̽ G͓̽ H͓̽ I͓̽ J͓̽ K͓̽ L͓̽ M͓̽ N͓̽ O͓̽ P͓̽ Q͓̽ R͓̽ S͓̽ T͓̽ U͓̽ V͓̽ W͓̽ X͓̽ Y͓̽ Z͓̽".split(
        " "
      ),
  },
  "anhnbt-code-038": {
    searches: letter.split(""),
    replaces:
      "ꍏ ꌃ ꉓ ꀸ ꍟ ꎇ ꁅ ꃅ ꀤ ꀭ ꀘ ꒒ ꎭ ꈤ ꂦ ᖘ ꆰ ꋪ ꌗ ꓄ ꀎ ᐯ ꅏ ꊼ ꌩ ꁴ ꍏ ꌃ ꉓ ꀸ ꍟ ꎇ ꁅ ꃅ ꀤ ꀭ ꀘ ꒒ ꎭ ꈤ ꂦ ᖘ ꆰ ꋪ ꌗ ꓄ ꀎ ᐯ ꅏ ꊼ ꌩ ꁴ".split(
        " "
      ),
  },
  "anhnbt-code-039": {
    searches: letter.split(""),
    replaces:
      "A᷈ B᷈ C᷈ D᷈ E᷈ F᷈ G᷈ H᷈ I᷈ J᷈ K᷈ L᷈ M᷈ N᷈ O᷈ P᷈ Q᷈ R᷈ S᷈ T᷈ U᷈ V᷈ W᷈ X᷈ Y᷈ Z᷈ A᷈ B᷈ C᷈ D᷈ E᷈ F᷈ G᷈ H᷈ I᷈ J᷈ K᷈ L᷈ M᷈ N᷈ O᷈ P᷈ Q᷈ R᷈ S᷈ T᷈ U᷈ V᷈ W᷈ X᷈ Y᷈ Z᷈".split(
        " "
      ),
  },
  "anhnbt-code-040": {
    searches: letter.split(""),
    replaces:
      "A͆ B͆ C͆ D͆ E͆ F͆ G͆ H͆ I͆ J͆ K͆ L͆ M͆ N͆ O͆ P͆ Q͆ R͆ S͆ T͆ U͆ V͆ W͆ X͆ Y͆ Z͆ A͆ B͆ C͆ D͆ E͆ F͆ G͆ H͆ I͆ J͆ K͆ L͆ M͆ N͆ O͆ P͆ Q͆ R͆ S͆ T͆ U͆ V͆ W͆ X͆ Y͆ Z͆".split(
        " "
      ),
  },
};

function onConvertTextToFancy() {
  for (let type in symbols) {
    let textSearches = symbols[type].searches;
    let textReplaces = symbols[type].replaces;
    let text = document.getElementById("input").value;
    for (let i in textSearches) {
      text = text
        .normalize("NFD")
        .replace(/đ/g, "d")
        .replace(/Đ/g, "D")
        .replace(new RegExp(textSearches[i], "g"), textReplaces[i]);
    }
    document.getElementById(type).value = text;
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
