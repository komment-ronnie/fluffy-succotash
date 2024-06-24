package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Is a summary of page numbers, page sizes, total pages, and total elements in a
 * paginated result. The class provides information on the number of pages and size
 * of each page, as well as the total number of pages and elements in the overall result.
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
     * Creates a `PageInfo` object containing information about the number of pages, page
     * size, total pages, and total elements for a given `Pageable` and `Page`.
     * 
     * @param pageable pagination information for the page being processed, providing the
     * page number, page size, total pages, and total elements.
     * 
     * @param page current page being processed, providing information on its position
     * and size within the overall paginated dataset.
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
