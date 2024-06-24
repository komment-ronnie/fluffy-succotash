package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Is used to store and manipulate page and limit information for a pageable object.
 * It provides a compact representation of the current page number, page limit, total
 * pages, and total elements. The class offers utility methods for constructing
 * instances and generating new PageInfos based on pageable and page objects.
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
     * Transforms a `Pageable` object and a `Page` object into a `PageInfo` object,
     * containing information about the page number, page size, total pages, and total elements.
     * 
     * @param pageable pagination information for the page being processed, providing the
     * page number, page size, total pages, and total elements.
     * 
     * @param page current page being processed, providing the total number of elements
     * on that page.
     * 
     * @returns a `PageInfo` object containing information about the current page and
     * total pages and elements.
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
