package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Represents a page of data in a paginated result set. It encapsulates metadata about
 * the current and total pages, as well as the total number of elements. The class
 * provides a static factory method to create instances from Spring Data Pageable and
 * Page objects.
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
     * Creates a `PageInfo` object with parameters taken from the `pageable` and `page`
     * objects, which include the current page number, page size, total pages, and total
     * elements. It initializes these properties within a new instance of the `PageInfo`
     * class.
     * 
     * @param pageable parameters for pagination, including the page number and size,
     * which are used to create a new instance of the `PageInfo` class.
     * 
     * @param page result of pagination, providing information about the total number of
     * pages and elements.
     * 
     * @returns a `PageInfo` object with four attributes.
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
