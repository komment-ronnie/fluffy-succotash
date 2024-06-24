package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Is designed to contain information about a page of data retrieved from a larger
 * dataset. It has four attributes: currentPage, pageLimit, totalPages, and totalElements.
 * These attributes provide details on the current page being displayed, the number
 * of elements per page, the total number of pages, and the total number of elements
 * in the dataset, respectively. The class also includes a constructor for creating
 * new instances of PageInfo based on a provided Pageable object and the corresponding
 * Page object.
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
     * Takes a `pageable` and a `page` as input and returns a `PageInfo` object containing
     * information about the page number, size, total pages, and total elements.
     * 
     * @param pageable page parameters of a pagination, providing the number of pages and
     * elements per page.
     * 
     * @param page current page being processed, providing information on its number,
     * size, total pages, and total elements.
     * 
     * @returns a `PageInfo` object containing page number, page size, total pages, and
     * total elements.
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
