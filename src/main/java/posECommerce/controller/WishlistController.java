package posECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posECommerce.domain.entity.dto.WishlistDto;
import posECommerce.service.IWishlistService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WishlistController {

    @Autowired
    private IWishlistService wishlistService;

    @PostMapping("/wishlist")
    public ResponseEntity<?> addProductToWishlist(@RequestBody WishlistDto wishlistDto){
        WishlistDto posWishlistDto = wishlistService.addProductToWishlist(wishlistDto);
        if (posWishlistDto == null)
            return ResponseEntity.badRequest().body("Something went wrong");
        return ResponseEntity.status(HttpStatus.CREATED).body(posWishlistDto);
    }


     @GetMapping("/wishlist/{userId}")
    public ResponseEntity<List<WishlistDto>> getWishlistByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(wishlistService.getWishlistByUserId(userId));
     }
}
