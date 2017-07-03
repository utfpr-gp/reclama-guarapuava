/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import br.edu.utfpr.model.Comment;
import br.edu.utfpr.model.Occurrence;
import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.CommentService;
import br.edu.utfpr.model.service.OccurrenceService;
import br.edu.utfpr.util.MessageUtil;
import br.edu.utfpr.util.MethodsUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author FELIPE
 */
@ManagedBean
@RequestScoped
public class CommentBean {
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

    public List<Comment> findAll() {
        return commentList = commentService.findAll();
    }
    
    public void reloadCommentList() {
        commentList = commentService.findByOccurrence(getOccurrenceId());
    }

    public void persist() {
        OccurrenceService occurrenceService = new OccurrenceService();
        Occurrence occurrence = occurrenceService.getById(getOccurrenceId());
        comment.setOccurrence(occurrence);
        
        if (!commentService.save(comment)) {
            MessageUtil.showMessage("Erro ao mentar a ocorrência", "", FacesMessage.SEVERITY_ERROR);
        } else {
            this.commentList.add(comment);
        }
    }

    public void delete(Comment comment) {
        boolean isSuccess = commentService.delete(comment);
        if (isSuccess) {
            this.commentList.remove(comment);
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        }
        this.comment = new Comment();
    }

    private Long getOccurrenceId() {
        return Long.parseLong(MethodsUtil.getRequest().getParameter("id"));
    }
}
