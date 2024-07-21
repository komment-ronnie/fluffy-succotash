package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Encapsulates pagination metadata for a given Pageable and Page objects, providing
 * a simple way to extract relevant information such as current page, total pages,
 * and total elements. The class is designed with private constructor and a public
 * static factory method "of" to create an instance from Pageable and Page parameters.
 * It utilizes Lombok annotations for improved code readability and maintainability.
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
     * Creates a `PageInfo` object with four properties: page number, page size, total
     * pages, and total elements. The properties are set from input parameters `pageable`,
     * which contains pagination information, and `page`, which holds the actual data page.
     * 
     * @param pageable pagination settings for the query, providing the current page
     * number and page size.
     * 
     * @param page result of the pagination, providing information about the total number
     * of pages and elements.
     * 
     * @returns a `PageInfo` object with four properties.
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
