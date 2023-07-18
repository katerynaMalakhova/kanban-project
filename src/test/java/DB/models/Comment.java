package models;

public class Comment {
    private String commentAuthor;
    private String commentContent;

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Comment() {
    }

    public Comment(String commentAuthor, String commentContent) {
        this.commentAuthor = commentAuthor;
        this.commentContent = commentContent;
    }
}
