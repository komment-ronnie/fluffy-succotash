package com.myhome.utils;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Is a data structure that encapsulates information about pages and elements in a
 * query result. It provides current page number, page limit, total pages, and total
 * elements. The class uses Lombok to implement access modifiers and automatic creation
 * of getters, setters, and toString methods.
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
     * Generates a `PageInfo` object containing information about the number of pages,
     * page size, total pages, and total elements of a given pageable and page.
     * 
     * @param pageable page number and size of the page being processed, which is used
     * to calculate the total pages and elements in the PageInfo object returned by the
     * function.
     * 
     * @param page current page being processed, providing the total number of elements
     * on that page.
     * 
     * @returns a `PageInfo` object containing page number, size, total pages, and total
     * elements.
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
