package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Is a data structure that encapsulates information about a page of results from a
 * larger dataset. It provides the current page number, page limit, total pages, and
 * total elements in the dataset. The class also includes static methods for creating
 * instances of the class based on Pageable objects and their associated pages.
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
     * Transforms a `Pageable` object and an associated `Page` object into a `PageInfo`
     * instance, providing information about the page number, size, total pages, and total
     * elements.
     * 
     * @param pageable page request parameters, such as the number of pages to retrieve
     * or the page size.
     * 
     * @param page current page being processed, providing information on its position
     * and size within the overall paginated result set.
     * 
     * @returns a `PageInfo` object containing page-related metadata.
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
