package com.myhome.utils;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * is a data structure used to represent information about a page of results in a
 * larger dataset. It contains four fields: currentPage, pageLimit, totalPages, and
 * totalElements. The class also includes a constructor for creating instances of the
 * class from a Pageable object and a Page object.
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
   * generates a `PageInfo` object containing information about the number of pages,
   * page size, total pages, and total elements for a given `Pageable` and `Page`.
   * 
   * @param pageable pagination information for the given page of data, providing the
   * page number, page size, total pages, and total elements.
   * 
   * 	- `pageable.getPageNumber()` represents the current page number being accessed.
   * 	- `pageable.getPageSize()` signifies the number of elements per page.
   * 	- `page.getTotalPages()` denotes the total number of pages in the collection.
   * 	- `page.getTotalElements()` indicates the overall quantity of elements in the collection.
   * 
   * @param page current page being processed, providing information on its position,
   * size, and total pages and elements in the collection.
   * 
   * 	- `pageNumber`: The page number that contains the element.
   * 	- `pageSize`: The number of elements in a single page.
   * 	- `totalPages`: The total number of pages available for the collection.
   * 	- `totalElements`: The total number of elements in the collection.
   * 
   * @returns a `PageInfo` object containing various pagination-related information.
   * 
   * 	- The first parameter, `pageable`, represents the pageable object that contains
   * information about the current page being processed.
   * 	- The second parameter, `page`, represents the page object itself, which contains
   * information such as the total number of pages and elements in the result set.
   * 	- The returned `PageInfo` object encapsulates these parameters and provides a
   * convenient way to access them.
   * 	- The `getPageNumber()` method returns the current page number being processed.
   * 	- The `getPageSize()` method returns the number of elements per page.
   * 	- The `getTotalPages()` method returns the total number of pages in the result set.
   * 	- The `getTotalElements()` method returns the total number of elements in the
   * result set.
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
