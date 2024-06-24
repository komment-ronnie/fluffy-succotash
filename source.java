package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Is a data representation class for page-related information. It stores four values:
 * currentPage, pageLimit, totalPages, and totalElements. The class generates new
 * instances based on a Pageable object and a Page object, providing information about
 * the number of pages, page size, total pages, and total elements for a given set
 * of data.
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
     * size, total pages, and total elements of a `Pageable` and its corresponding `Page`.
     * 
     * @param pageable pageable object that contains information about the current page
     * being processed, including the page number and size.
     * 
     * @param page current page being processed, providing information on its position
     * and size within the overall paginated result.
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
