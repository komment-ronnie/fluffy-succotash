package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Represents an object that encapsulates page-related information from a Spring Data
 * JPA Pageable and Page objects. It is designed to be immutable with private final
 * fields and is created through a static factory method of(). The class provides
 * getters for the page information and is annotated for equals, toString, and required
 * constructor creation.
 */
@EqualsAndHashCode
@ToString
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PageInfo {
  private final int currentPage;
  private final int pageLimit;
  private final int totalPages;
  private final long totalElements;
  
    /**
     * Initializes a `PageInfo` object by extracting pagination information from the
     * provided `pageable` and `page` objects, including the current page number, page
     * size, total pages, and total elements. It then returns the created `PageInfo` instance.
     * 
     * @param pageable pagination parameters for retrieving data from a database, allowing
     * control over the number of pages and elements to be retrieved.
     * 
     * @param page result of the pagination process, providing total pages and total elements.
     * 
     * @returns a `PageInfo` object with specified parameters.
     */
    public static PageInfo of(Pageable pageable, Page<?> page) {
    return new PageInfo(
        pageable.getPageNumber(),
        pageable.getPageSize(),
        page.getTotalPages(),
        page.getTotalElements()
    );
  }
}
