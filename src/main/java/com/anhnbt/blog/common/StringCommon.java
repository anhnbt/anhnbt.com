package com.anhnbt.blog.common;

public class StringCommon {
    private static final char[] NOSIGN = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'd', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'i', 'i', 'i', 'i', 'i', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'y', 'y', 'y', 'y', 'y', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'D', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'I', 'I', 'I', 'I', 'I', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'Y', 'Y', 'Y', 'Y', 'Y'};

    public static String stripHtmlTags(String html) {
        return html.replaceAll("<.*?>", "");
    }

    public static boolean isNullOrBlank(String str) {
        return str == null || str.trim().equals("");
    }

    public static String removeVietnameseSign(String s) {
        String result = "";
        if (isNullOrBlank(s)) {
            return result;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int pos;
            if ((pos = "áàảãạăắằẳẵặâấầẩẫậđéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬĐÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴ".indexOf(c)) != -1) {
                result = new StringBuilder().append(result).append(NOSIGN[pos]).toString();
            } else {
                result = new StringBuilder().append(result).append(c).toString();
            }
        }
        result = result.replaceAll("[^-a-zA-Z0-9~!@#$%^&*()_+={}\\[\\]|\\\\/?<>,\"':;. ]+", "");
        return result;
    }

    public static String createSlug(String s) {
        String result = "";
        if (isNullOrBlank(s)) {
            return result;
        }
        result = removeVietnameseSign(s.toLowerCase());
        result = result.replaceAll(" ", "-");
        result = result.replaceAll("-{2,}", "-");
        return result;
    }
}
