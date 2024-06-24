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
     * @param pageable page request parameters, such as the page number and page size,
     * which are used to determine the corresponding page of data.
     * 
     * @param page current page being processed, providing information on its position,
     * size, total pages, and total elements within thePageable object.
     * 
     * @returns a `PageInfo` object containing information about the page number, size,
     * total pages, and total elements of the pageable.
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
