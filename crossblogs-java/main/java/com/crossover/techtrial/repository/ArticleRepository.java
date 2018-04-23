package com.crossover.techtrial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.crossover.techtrial.model.Article;

@RepositoryRestResource(exported = false)
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
	@Query(value="select a from Article a where LOWER(a.title) like LOWER(?1) OR LOWER(a.content) like LOWER(?2) order by date desc")
	/*@Query("SELECT t FROM Article t WHERE " +
            "LOWER(t.title) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.content) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
	*/List<Article> findTop10ByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title,String content);

}
