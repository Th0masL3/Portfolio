import { test, expect } from '@playwright/test';


test('test', async ({ page }) => {
   await page.goto('http://localhost:3000/consoles');
   await expect(page.getByRole('cell', { name: '675b23a925b2c7669c35b62d' })).toBeVisible();
   await page.getByRole('cell', { name: '675b23a925b2c7669c35b62d' }).click();
   await expect(page.getByRole('button', { name: 'Add Game' })).toBeVisible();
   await page.getByRole('button', { name: 'Add Game' }).click();
   await page.getByLabel('Name:', { exact: true }).click();
   await page.getByLabel('Name:', { exact: true }).fill('ala');
   await expect(page.getByLabel('Name:', { exact: true })).toBeVisible();
   await page.locator('input[name="productSalePrice"]').click();
   await page.locator('input[name="productSalePrice"]').fill('11');
   await page.getByText('Description:').click();
   await page.getByLabel('Description:').click();
   await page.getByLabel('Description:').fill('djoa');
   await page.getByLabel('Genre:').click();
   await page.getByLabel('Genre:').fill('asd1');
   await page.getByLabel('Quantity:').click();
   await page.getByLabel('Quantity:').fill('1');
   await page.getByLabel('Genre:').click();
   await page.getByLabel('Genre:').fill('asd');
   await page.getByRole('button', { name: 'Add Game' }).click();
   await expect(page.getByRole('cell', { name: 'ala' }).nth(1)).toBeVisible();
  });

