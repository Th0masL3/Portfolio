import { test, expect } from '@playwright/test';


test('test', async ({ page }) => {
    await page.goto('http://localhost:3000/consoles');
    await page.getByRole('cell', { name: '675b23a925b2c7669c35b62d' }).click();
    await expect(page.getByRole('button', { name: 'Add Game' })).toBeVisible();
    await page.getByRole('button', { name: 'Add Game' }).click();
    await expect(page.getByText('Add GameName:Price:')).toBeVisible();
    await page.getByLabel('Name:', { exact: true }).click();
    await page.locator('input[name="productSalePrice"]').click();
    await page.getByLabel('Description:').click();
    await page.getByLabel('Genre:').click();
    await page.getByLabel('Quantity:').click();
    await page.getByLabel('Quantity:').fill('1');
    await expect(page.getByRole('button', { name: 'Add Game' })).toBeVisible();
    await page.getByRole('button', { name: 'Add Game' }).click();
    await expect(page.getByRole('cell', { name: 'ala' })).toBeVisible();
  });


