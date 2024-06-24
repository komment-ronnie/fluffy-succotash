package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Is a data structure that encapsulates information about a page of results in a
 * larger dataset. It contains four fields: currentPage, pageLimit, totalPages, and
 * totalElements. These fields provide the current page being viewed, the maximum
 * number of pages available, the total number of pages, and the total number of
 * elements in the dataset, respectively.
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
     * size of each page, total number of pages, and total elements for a given pageable
     * and page.
     * 
     * @param pageable pagination information for the page being processed, providing the
     * page number, page size, total pages, and total elements.
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
