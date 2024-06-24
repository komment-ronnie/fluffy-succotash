package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Is used to represent metadata about a page of data. It contains four fields:
 * currentPage, pageLimit, totalPages, and totalElements. These fields are used to
 * calculate various pagination-related metrics, such as the number of pages required
 * to display a certain amount of data or the total number of elements in all pages.
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
     * page size, total pages, and total elements of a given `Pageable` and `Page`.
     * 
     * @param pageable pageable object that contains information about the current page
     * of data being processed, providing the page number and size for calculation of the
     * total pages and elements in the dataset.
     * 
     * @param page current page of results being processed, providing the total number
     * of elements on that page.
     * 
     * @returns a `PageInfo` object containing pagination information for the given
     * `pageable` and `page`.
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
