package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Is a data structure used to represent page information for a paginated dataset.
 * It contains four attributes: currentPage, pageLimit, totalPages, and totalElements.
 * The class provides a convenient way to create a PageInfo object from a Pageable
 * and a Page instance.
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
     * Takes a `pageable` and a `page` as input, and returns a `PageInfo` object containing
     * information about the page number, page size, total pages, and total elements.
     * 
     * @param pageable pagination information for the current page of data, including the
     * number of pages and the size of each page.
     * 
     * @param page current page being processed, providing information on its position
     * and size within the overall pageable dataset.
     * 
     * @returns a `PageInfo` object containing information about the current page of a
     * paginated result.
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
