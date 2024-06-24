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
     * Generates a `PageInfo` object containing information about the number of pages,
     * page size, total pages, and total elements for a given `Pageable` and `Page`.
     * 
     * @param pageable page request, providing information about the number of pages and
     * elements per page.
     * 
     * @param page current page being processed, providing the total number of elements
     * on that page.
     * 
     * @returns a `PageInfo` object containing four properties: page number, page size,
     * total pages, and total elements.
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
