package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Represents a pagination object containing four attributes: current page number,
 * page limit, total pages, and total elements. It provides a factory method to create
 * an instance from Spring's Pageable and Page objects. The class is designed with
 * the use of Lombok annotations for improved readability and maintainability.
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
     * Creates a new `PageInfo` object based on input parameters. It initializes the
     * object with page number, page size, total pages, and total elements from the
     * provided `pageable` and `page` objects. The resulting object encapsulates pagination
     * metadata for further processing.
     * 
     * @param pageable pagination information, providing the current page number and page
     * size.
     * 
     * @param page 0-indexed page object returned by the repository method, providing
     * information about the total number of pages and elements in the result set.
     * 
     * @returns a `PageInfo` object with pagination details.
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
