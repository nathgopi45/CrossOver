package com.crossover.techtrial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crossover.techtrial.model.Comment;
import com.crossover.techtrial.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  CommentRepository commentRepository;

  /*
   * Returns all the Comments related to article along with Pagination information.
   */
  public List<Comment> findAll(Long articleId) {
	  if(articleId==null) return null;
    return commentRepository.findAll();
  }

  /*
   * Save the default article.
   */
  public Comment save(Comment comment) {
	  if(comment==null) return null;
    return commentRepository.save(comment);
  }

}
