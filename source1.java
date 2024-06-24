package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Is a data structure used to represent information about a page of elements. It
 * consists of four fields: currentPage, pageLimit, totalPages, and totalElements.
 * The class provides a convenient way to create instances of PageInfo from a Pageable
 * object and its corresponding Page.
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
     * Returns a `PageInfo` object containing information about the number of pages, page
     * size, total pages, and total elements for a given `Pageable` and `Page`.
     * 
     * @param pageable pageable object that contains information about the current page
     * being processed, including the number of elements per page and the total number
     * of pages in the dataset.
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
