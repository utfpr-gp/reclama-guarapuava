/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import br.edu.utfpr.model.Comment;
import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.CommentService;
import br.edu.utfpr.util.MessageUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author FELIPE
 */
@ManagedBean
@RequestScoped
public class CommentBean {

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    private Comment comment;
    private List<Comment> commentList;
    private CommentService commentService;

    /**
     * Creates a new instance of CommentBean
     */
    public CommentBean() {
    }

    @PostConstruct
    public void init() {
        comment = new Comment();
        commentList = new ArrayList<>();
        commentService = new CommentService();
    }

    public List<Comment> findAll() {
        return commentList = commentService.findAll();
    }

    public void persist() {
        User u = new User();
        System.out.println("jajaja");
        System.out.println(u.getLogin());
        System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
        Comment c = new Comment();
        u.setLogin(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
        c.setUser(u);
        System.out.println(c.getUser().getLogin());
        if (this.comment.getId() == null) {
            if (commentService.save(comment)) {
                this.commentList.add(comment);
                MessageUtil.showMessage("Persistido com sucesso", "", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Por favor escolha um artista", "", FacesMessage.SEVERITY_ERROR);
            }
        } else {
            commentService.update(comment);
        }
        this.comment = new Comment();
    }

    public void delete(Comment comment) {
        boolean isSuccess = commentService.delete(comment);
        if (isSuccess) {
            this.commentList.remove(comment);
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        }
        this.comment = new Comment();
    }

}
