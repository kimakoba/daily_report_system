package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Customer;

public class CustomerValidator {
     public static List<String> validate(Customer c) {
            List<String> errors = new ArrayList<String>();

            String company_error = _validateCompany(c.getCompany());
            if(!company_error.equals("")) {
                errors.add(company_error);
            }

            String name_error = _validateName(c.getName());
            if(!name_error.equals("")) {
                errors.add(name_error);
            }

            String gender_error = _validateGender(c.getGender());
            if(!gender_error.equals("")) {
                errors.add(gender_error);
            }

            String email_error = _validateEmail(c.getEmail());
            if(!email_error.equals("")) {
                errors.add(email_error);
            }

            String phone_error = _validatePhone(c.getPhone());
            if(!phone_error.equals("")) {
                errors.add(phone_error);
            }

            String memo_error = _validateMemo(c.getMemo());
            if(!memo_error.equals("")) {
                errors.add(memo_error);
            }

            return errors;
        }

        private static String _validateCompany(String company) {
            if(company == null || company.equals("")) {
                return "会社名を入力してください。";
            }

            return "";
        }

        private static String _validateName(String name) {
            if(name == null || name.equals("")) {
                return "顧客名を入力してください。";
                }

            return "";
        }

        private static String _validateGender(String gender) {
            if(gender == null || gender.equals("")) {
                return "性別を入力してください。";
                }

            return "";
        }

        private static String _validateEmail(String email) {
            if(email == null || email.equals("")) {
                return "メールアドレスを入力してください。";
            }

            return "";
        }

        private static String _validatePhone(String phone) {
            if(phone == null || phone.equals("")) {
                return "電話番号を入力してください。";
                }

            return "";
        }

        private static String _validateMemo(String memo) {
            if(memo == null || memo.equals("")) {
                return "メモを入力してください。";
            }
            return "";
        }
    }

