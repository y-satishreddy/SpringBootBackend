@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest{
  @Mock
  private ProductRepository productRepository;
  @Mock
  private ProductMapper productMapper;

  @InjectMocks
  private ProductServiceImpl productServiceImpl;

  @Test
  public void saveProductTest(){
  ProductAddProductRequestDTO productDTO=new ProductAddProductRequestDTO(true,true,"test product","test-product",1L,"test",20.0,17.0,"short test desc","long test desc");
  Product toEntityProduct=new Product();
  Product savedProduct=new Product();
  ProductAddProductResponseDTO responseProduct=new ProductAddProductResponseDTO(1L,"test product","test-product",1L,"test",20.0,17.0,"short test desc","long test desc",true,true,LocalDateTime.now());
  when(productMapper.toEntity(productDTO)).thenReturn(toEntityProduct);
  when(productRepository.save(toEntityProduct)).thenReturn(savedProduct);
  when(productMapper.toAddResponse(savedProduct)).thenReturn(responseProduct);
  ProductAddProductResponseDTO response=productService.saveProduct(productDTO);
  assertEquals("test product",response.getName());
  verify(productMapper).toEntity(productDTO);
  verify(productRepository).save(toEntityProduct);
  verify(productMapper.toAddResponse(savedProduct);
  }

  @Test
  public void getProductTest(){
  Long id=2L;
  Product product=new Product();
  ProductGetProductResponseDTO responseDTO=new ProductGetProductResponseDTO(2L,"test product","test-product",1L,"test",20.0,17.0,"short test desc","long test desc",true,true,LocalDateTime.now());
  when(productRepository.findById(id)).thenReturn(Optional.of(product));
  when(productMapper.toGetDetailsResponse(product)).thenReturn(responseDTO);
  ProductGetProductResponseDTO response = productServiceImpl.getProduct(id);
  assertEquals(2L,response.getId());
  verify(productRepository).findById(id);
  verify(productMapper).toGetDetailsResponse(product);
  }

  @Test
  public void testProductNotFoundException(){
  Long id=1L;
  when(productRepository.findById(id)).thenReturn(Optional.empty());
  ProductNotFoundException exception= assertThrows(ProductNotFoundException.class,() -> productService.getProduct(id));
  assertEquals("Product not found with id : 1",exception.getMessage());
  verify(productRepository).findById(id);
  }
  
}
