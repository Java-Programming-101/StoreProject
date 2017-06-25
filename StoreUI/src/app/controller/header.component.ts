import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: '/app/view/html/header.component.html',
  styleUrls: ['app/view/css/header.component.css'],
})
export class HeaderComponent implements OnInit {
/*
  isAuthenticated: Observable<boolean>;
  totalCartItems: Observable<number>;
  taxonomies$: Observable<any>;
  taxonList = [{
    "id": 4,
    "name": "Mugs",
    "pretty_name": "Categories -> Mugs",
    "permalink": "categories/mugs",
    "parent_id": 1,
    "taxonomy_id": 1,
    "taxons": null},
  {
    "id": 3,
    "name": "Bags",
    "pretty_name": "Categories -> Bags",
    "permalink": "categories/bags",
    "parent_id": 1,
    "taxonomy_id": 1,
    "taxons": null
  }, {
    "id": 8,
    "name": "Ruby",
    "pretty_name": "Brand -> Ruby",
    "permalink": "brand/ruby",
    "parent_id": 2,
    "taxonomy_id": 2,
    "taxons": null
  }, {
     "id": 9,
    "name": "Apache",
    "pretty_name": "Brand -> Apache",
    "permalink": "brand/apache",
    "parent_id": 2,
    "taxonomy_id": 2,
    "taxons": null
  }, {
    "id": 10,
    "name": "Spree",
    "pretty_name": "Brand -> Spree",
    "permalink": "brand/spree",
    "parent_id": 2,
    "taxonomy_id": 2,
    "taxons": null
  }, {
    "id": 11,
    "name": "Rails",
    "pretty_name": "Brand -> Rails",
    "permalink": "brand/rails",
    "parent_id": 2,
    "taxonomy_id": 2,
    "taxons": null
  }];
*/
/*
  constructor(
    private store: Store<AppState>,
    private authService: AuthService,
    private authActions: AuthActions,
    private searchActions: SearchActions,
    private router: Router
  ) {
    this.taxonomies$ = this.store.select(getTaxonomies);
  }
*/


  ngOnInit() {
/*
    this.store.dispatch(this.authActions.authorize());
    this.isAuthenticated = this.store.select(getAuthStatus);
    this.totalCartItems = this.store.select(getTotalCartItems);
*/
  }

/*
  selectTaxon(taxon) {
    this.router.navigateByUrl('/');
    this.store.dispatch(this.searchActions.addFilter(taxon));
  }
*/

}
