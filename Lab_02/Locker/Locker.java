public class Locker {

    private boolean isOpen;
    private String code;

    public Locker() {
        isOpen = true;
        code = "";
    }

    public void unlock(String code) {
        if(!this.isOpen && this.code.equals(code))
            this.isOpen = true;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void lock() {
        if(this.isOpen == true)
            this.isOpen = false;
    }

    public void newComb(String newCode) {
        if(isOpen){
            this.code = newCode;
        }
    }
}