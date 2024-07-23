package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



/**
 * Represents an immutable object that encapsulates pagination metadata from Spring
 * Data Pageable and Page objects. It is designed to provide easy access to page-related
 * information such as the current page number, total pages, and total elements. This
 * class allows for efficient creation of PageInfo instances using a factory method.
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
     * Initializes a new instance of `PageInfo`. It sets the current page number, page
     * size, total pages, and total elements based on the provided `pageable` and `page`
     * objects. This data is then used to create a `PageInfo` object for further processing
     * or display.
     * 
     * @param pageable pagination criteria, providing information about the current page
     * number and size.
     * 
     * @param page result of paginating a collection, providing information about the
     * total number of pages and elements.
     * 
     * @returns a `PageInfo` object with specified page number, size, total pages, and elements.
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
