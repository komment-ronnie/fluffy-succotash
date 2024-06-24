package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Is designed to store and manipulate information about a page of data, including
 * current page number, page size, total pages, and total elements. The class provides
 * a constructor for creating new instances based on a provided Pageable object and
 * the corresponding Page object.
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
     * @param pageable Pageable object that contains information about the current page
     * of data being processed, which is used to calculate the page number, page size,
     * total pages, and total elements of the resulting PageInfo object.
     * 
     * @param page current page being processed, providing information on its position,
     * size, and total pages and elements in the paginated data set.
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
