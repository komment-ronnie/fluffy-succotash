package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Is designed to encapsulate information about a page of data. It provides a static
 * method to generate an instance based on Pageable and Page objects, which contains
 * details such as the current page number, page size, total pages, and total elements.
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
     * Initializes a new instance of `PageInfo`, which represents pagination information,
     * using parameters from `Pageable` and `Page`. It sets properties such as page number,
     * page size, total pages, and total elements based on the input.
     * 
     * @param pageable pager used to extract the necessary information from the provided
     * page, such as the current page number and page size.
     * 
     * @param page result of pagination, providing total pages and total elements for the
     * given query or request.
     * 
     * @returns an instance of `PageInfo`, containing pagination metadata.
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
