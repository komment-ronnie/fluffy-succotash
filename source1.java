package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Is designed to encapsulate information about pagination of a dataset. It provides
 * a utility method to create an instance of PageInfo from a Pageable and a Page
 * object. This class aims to simplify the process of retrieving page-related metadata
 * for efficient data processing and presentation.
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
     * Creates a `PageInfo` object with four attributes: page number, page size, total
     * pages, and total elements. The attributes are populated from the provided `Pageable`
     * and `<Page>` objects.
     * 
     * @param pageable pagination parameters, providing information about the current
     * page number and size.
     * 
     * @param page 0-indexed Page object that provides information about the current page,
     * such as total pages and total elements.
     * 
     * @returns a `PageInfo` object.
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
