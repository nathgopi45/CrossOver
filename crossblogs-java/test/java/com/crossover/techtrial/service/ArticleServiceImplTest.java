package com.crossover.techtrial.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.crossover.techtrial.model.Article;
import com.crossover.techtrial.repository.ArticleRepository;

@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceImplTest {
	
	@InjectMocks
	ArticleServiceImpl articleServiceImpl;
	
	@Mock
	ArticleRepository articleRepository;
	
	@Test
	public void testSaveArticle() {
		Article article = getStubArticle();
		Mockito.when(articleRepository.save(Mockito.any(Article.class))).thenReturn(article);	
		Assert.assertNotNull(articleServiceImpl.save(article));
		
	}
	
	@Test
	public void testFindArticleByInvalidId() {
		Article article = getStubArticle();
		Mockito.when(articleRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.empty());
		Assert.assertNull(articleServiceImpl.findById(2l));
		
	}
	
	@Test	
	public void testDeleteArticle() {
		Article article = getStubArticle();
		//Mockito.doNothing().when(articleRepository).delete(Mockito.any(Article.class));
		articleServiceImpl.delete(2l);
		//Assert.assertTrue(true);
		
	}
	
	@Test
	public void testSearchArticle() {
		Article article = getStubArticle();
		List<Article> list = new ArrayList<Article>();
		list.add(article);
		Mockito.when(articleRepository.findTop10ByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(Mockito.anyString(),Mockito.anyString())).thenReturn(list);
		List<Article> result=articleServiceImpl.search("Hi");
		Assert.assertNotNull(result);
		Assert.assertTrue(result.size()>0);
		
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
