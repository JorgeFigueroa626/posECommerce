package posECommerce.service.customer;

import posECommerce.domain.entity.dto.WishlistDto;

import java.util.List;

public interface IWishlistService {

    public WishlistDto addProductToWishlist(WishlistDto wishlistDto);

    public List<WishlistDto> getWishlistByUserId(Long userId);
}
