package com.crossover.techtrial.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.crossover.techtrial.model.Article;
import com.crossover.techtrial.model.Comment;
import com.crossover.techtrial.repository.CommentRepository;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceImplTest {

	@Mock
	CommentRepository commentRepository;
	@InjectMocks
	CommentServiceImpl commentServiceImpl;


	@Test
	public void testFindAllComment() {
		Comment comment = getStubComment();
		List<Comment> list = new ArrayList<Comment>();
		list.add(comment);
		Mockito.when(commentRepository.findAll()).thenReturn(list);
		List<Comment> result=commentServiceImpl.findAll(2l);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.size()>0);

	}

	@Test
	public void testSaveComment() {
		Comment comment = getStubComment();
		Mockito.when(commentRepository.save(Mockito.any(Comment.class))).thenReturn(comment);	
		Assert.assertNotNull(commentServiceImpl.save(comment));

	}


	private Comment getStubComment() {
		Comment comment = new Comment();
		comment.setArticle(getStubArticle());
		comment.setDate(LocalDateTime.now());
		comment.setEmail("nail@pubilisher.com");
		comment.setId(2l);
		comment.setMessage("Very nice article");
		return comment;
	}

	private Article getStubArticle() {
		Article article= new Article();
		article.setId(2l);
		article.setEmail("nail@pubilisher.com");
		article.setPublished(true);
		article.setTitle("hello");
		article.setContent("hi this is sample test case");
		article.setDate(LocalDateTime.now());
		return article;
	}
}
