package com.crossover.techtrial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.techtrial.exceptions.GlobalExceptionHandler;
import com.crossover.techtrial.model.Article;
import com.crossover.techtrial.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  ArticleRepository articleRepository;

  @Override
  public Article save(Article article) {
	  if(article==null) return null;
    return articleRepository.save(article);
  }

  @Override
  public Article findById(Long id) {
	  if(id==null) return null;
    return articleRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(Long id) {
	  if(id==null) return ;
    articleRepository.deleteById(id);
  }

  @Override
  public List<Article> search(String search) {
	  System.out.println("searching for string = "+search);
    return articleRepository
        .findTop10ByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(search, search);
  }

}