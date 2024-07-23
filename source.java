package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



/**
 * Is designed to encapsulate pagination metadata for Spring Data Pageable API results.
 * It provides a static method "of" to create an instance of PageInfo from a given
 * Pageable and a Page object, utilizing various properties such as current page
 * number, total pages, and total elements.
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
     * Constructs a `PageInfo` object from provided parameters. It takes a `Pageable` and
     * a `Page` as input, extracting information such as the current page number, page
     * size, total pages, and total elements to create the `PageInfo`.
     * 
     * @param pageable pagination criteria for retrieving data, allowing to specify the
     * page number and page size.
     * 
     * @param page result of a paginated query, providing information about the total
     * number of pages and elements.
     * 
     * @returns a `PageInfo` object containing page number, page size, total pages, and
     * total elements.
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
