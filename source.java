package com.myhome.utils;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Is a data structure that encapsulates metadata about pages and their elements. It
 * provides information such as the current page number, page size, total number of
 * pages, and total number of elements. This class is used to return page-related
 * metadata based on a provided Pageable object and a passed Page object.
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
     * Takes a `pageable` and a `page` as input, returns a `PageInfo` object with information
     * about the page number, size, total pages, and total elements.
     * 
     * @param pageable pagination information for the current page of data being processed,
     * providing the page number, page size, total pages, and total elements.
     * 
     * @param page current page being processed, providing information on its position
     * within the overall range of pages and the total number of elements in the collection
     * being paginated.
     * 
     * @returns a `PageInfo` object containing information about the page number, size,
     * total pages, and total elements of a pageable.
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
