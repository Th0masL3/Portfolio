import { test, expect } from '@playwright/test';

// update
test('test', async ({ page }) => {
  await page.goto('http://localhost:3000/consoles');
  await page.getByRole('row', { name: '6753e3ecea5002049c0ada8b' }).getByRole('button').click();
  await page.locator('input[name="consoleName"]').click();
  await page.locator('input[name="consoleName"]').fill('dwadadddwda');
  await page.locator('input[name="releaseDate"]').fill('1995-06-22');
  await page.locator('input[name="price"]').click();
  await page.locator('input[name="price"]').fill('20');
  await page.locator('input[name="quantityInStock"]').click();
  await page.locator('input[name="quantityInStock"]').fill('5');
  await page.locator('input[name="company"]').click();
  await page.locator('input[name="company"]').fill('hi');
  await page.getByRole('button', { name: 'Save' }).click();
});