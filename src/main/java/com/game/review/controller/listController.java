/*
 * package com.game.review.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod;
 * 
 * import com.game.review.Service.ArticlesService; import
 * com.game.review.dto.GamesDTO;
 * 
 * @Controller
 * 
 * @RequestMapping("list")
 * 
 * //지워도 상관없는 그냥 리스트 확인용 public class listController {
 * 
 * @Autowired private ArticlesService articlesservice ;
 * 
 * @RequestMapping(method = RequestMethod.GET) public String list(Model model) {
 * List<GamesDTO> game = articlesservice.selectAll() ;
 * model.addAttribute("game", game) ; return "/list" ;
 * 
 * } }
 */