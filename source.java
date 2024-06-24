package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Provides a way to represent page information for a collection of data. It includes
 * four fields: currentPage, pageLimit, totalPages, and totalElements. The class also
 * includes a static method for creating new instances based on a Pageable object and
 * a Page object.
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
     * @param pageable pageable object that contains information about the current page
     * being processed, including the page number and size.
     * 
     * @param page current page of data being processed, providing the total number of
     * elements on that page.
     * 
     * @returns a `PageInfo` object containing various pagination-related information.
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
