package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Is designed to encapsulate pagination information for a given dataset. It provides
 * a static method to create an instance of PageInfo from a Pageable object and a
 * Page object. The class is optimized for immutability, ensuring that its state
 * cannot be altered after creation.
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
     * Constructs a `PageInfo` object based on provided parameters: `pageable` and `page`.
     * The constructed object holds information about the current page number, page size,
     * total pages, and total elements.
     * 
     * @param pageable information about the current page, including its number and size,
     * which is used to construct the PageInfo object.
     * 
     * @param page result of pagination, providing total pages and total elements information.
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
