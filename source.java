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
 * query result. It provides the current page number, page limit, total pages, and
 * total elements. The class uses Lombok to implement access modifiers and automatic
 * creation of getters, setters, and toString methods.
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
     * Creates a `PageInfo` object containing information about a given pageable and page,
     * including the current page number, page size, total pages, and total elements.
     * 
     * @param pageable pageable information of the data being processed, providing the
     * page number, page size, total pages, and total elements for the current page.
     * 
     * @param page current page being processed, providing its total elements and pages
     * count to be used in calculating the page number and size for output.
     * 
     * @returns a `PageInfo` object containing information about the current page of data.
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
