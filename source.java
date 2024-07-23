package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Encapsulates page-related data for efficient pagination. It is designed to work
 * with Spring Data's Pageable and Page interfaces. The class provides a static factory
 * method to create instances of PageInfo from Pageable and Page objects.
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
     * Initializes a `PageInfo` object with parameters from a given `Pageable` and a
     * `Page`. It takes the page number, page size, total pages, and total elements from
     * the input objects and constructs a new `PageInfo` instance.
     * 
     * @param pageable pagination criteria for the requested data, allowing for the
     * retrieval of specific pages and sizes of elements.
     * 
     * @param page result of pagination operation, providing information about the total
     * number of elements and pages.
     * 
     * @returns a PageInfo object with specified attributes.
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
