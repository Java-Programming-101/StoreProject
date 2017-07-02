import { EcommercePage } from './app.po';

describe('ecommerce App', () => {
  let page: EcommercePage;

  beforeEach(() => {
    page = new EcommercePage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
