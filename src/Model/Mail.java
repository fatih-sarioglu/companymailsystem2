package Model;

public class Mail {
    private String mailTo, mailFrom, mailSubject, mailContent, mailTime, mailBox;

    public Mail(String mailTo, String mailFrom, String mailSubject, String mailContent, String mailTime, String mailBox) {
        this.mailTo = mailTo;
        this.mailFrom = mailFrom;
        this.mailSubject = mailSubject;
        this.mailContent = mailContent;
        this.mailTime = mailTime;
        this.mailBox = mailBox;
    }
    
    public Mail(){}
    
    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getMailTime() {
        return mailTime;
    }

    public void setMailTime(String mailTime) {
        this.mailTime = mailTime;
    }

    public String getMailBox() {
        return mailBox;
    }

    public void setMailBox(String mailBox) {
        this.mailBox = mailBox;
    }
}
