package blutechnologies.com.parentalcontrol.dataModels;

import java.util.List;

public class RegisterResponse {

    private boolean success;
    private String access_token;
    private String message;
    private Error error;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public class Error {

        private List<String> first_name;
        private List<String> last_name;
        private List<String> email;
        private List<String> password;
        private List<String> confirm_password;

        public List<String> getFirst_name() {
            return first_name;
        }

        public void setFirst_name(List<String> first_name) {
            this.first_name = first_name;
        }

        public List<String> getLast_name() {
            return last_name;
        }

        public void setLast_name(List<String> last_name) {
            this.last_name = last_name;
        }

        public List<String> getEmail() {
            return email;
        }

        public void setEmail(List<String> email) {
            this.email = email;
        }

        public List<String> getPassword() {
            return password;
        }

        public void setPassword(List<String> password) {
            this.password = password;
        }

        public List<String> getConfirm_password() {
            return confirm_password;
        }

        public void setConfirm_password(List<String> confirm_password) {
            this.confirm_password = confirm_password;
        }
    }
}
