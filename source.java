package com.myhome.utils;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Is an utility class for managing page information, such as current page, limit per
 * page, total pages and total elements. The class provides a constructor to create
 * instances of the class with values from a given pageable and page objects.
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
     * Returns a `PageInfo` object containing information about the number of pages, size
     * of each page, total number of pages and elements, based on a provided `Pageable`
     * object and a passed `Page` object.
     * 
     * @param pageable page number and size of the page being queried, which are used to
     * calculate the total pages and elements in the PageInfo object returned by the function.
     * 
     * @param page current page being processed, providing the total number of elements
     * on that page.
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
